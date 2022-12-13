package com.baz.infofootball.feature.standings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baz.infofootball.core.ui.Result
import com.baz.infofootball.data.standings.repository.IStandingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StandingsViewModel @Inject constructor(private val repository: IStandingsRepository) :
    ViewModel() {

    private val _uiState: MutableStateFlow<StandingsState> = MutableStateFlow(StandingsState())
    val uiState: StateFlow<StandingsState> = _uiState.asStateFlow()

    init {
        getStandings()
    }

    private fun getStandings() {
        viewModelScope.launch {
            repository.getStandings().collectLatest {
                when (it) {
                    is Result.Success -> {
                        it.data?.let { standings ->
                            _uiState.value = StandingsState(
                                name = standings.name,
                                country = standings.country,
                                season = standings.season,
                                data = standings.data
                            )
                        }
                    }
                    is Result.Error -> {
                        it.message?.let { error ->
                            _uiState.value = StandingsState(error = error)
                        }
                    }
                    is Result.Loading -> _uiState.value = StandingsState(isLoading = true)
                }
            }
        }
    }
}
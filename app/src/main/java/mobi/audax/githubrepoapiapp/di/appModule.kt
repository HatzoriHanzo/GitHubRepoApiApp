package mobi.audax.githubrepoapiapp.di

import mobi.audax.githubrepoapiapp.domain.repository.RepositoriesRepository
import mobi.audax.githubrepoapiapp.presentation.fragments.RepositoryFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        RepositoriesRepository()

    }

    viewModel {
        RepositoryFragmentViewModel(get())
    }


}
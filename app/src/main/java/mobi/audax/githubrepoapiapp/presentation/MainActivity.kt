package mobi.audax.githubrepoapiapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mobi.audax.githubrepoapiapp.R
import mobi.audax.githubrepoapiapp.presentation.fragments.RepositoryFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val viewModel: RepositoryFragmentViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

}
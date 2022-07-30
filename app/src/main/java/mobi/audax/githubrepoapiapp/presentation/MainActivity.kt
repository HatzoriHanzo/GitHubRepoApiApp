package mobi.audax.githubrepoapiapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mobi.audax.githubrepoapiapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val viewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

}
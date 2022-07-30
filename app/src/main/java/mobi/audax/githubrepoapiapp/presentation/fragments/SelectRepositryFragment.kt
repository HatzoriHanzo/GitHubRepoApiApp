package mobi.audax.githubrepoapiapp.presentation.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_select_repository.*
import mobi.audax.githubrepoapiapp.R
import mobi.audax.githubrepoapiapp.presentation.MainActivity
import mobi.audax.githubrepoapiapp.presentation.MainActivityViewModel

class SelectRepositryFragment : Fragment(R.layout.fragment_select_repository) {
    lateinit var viewModel: MainActivityViewModel
    val args: SelectRepositryFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel

        val item = args.repositoryItem
        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(item.html_url)
        }

    }
}
package mobi.audax.githubrepoapiapp.presentation.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_repository.*
import mobi.audax.githubrepoapiapp.R
import mobi.audax.githubrepoapiapp.presentation.MainActivity
import mobi.audax.githubrepoapiapp.presentation.adapter.RepositoriesAdapter
import mobi.audax.githubrepoapiapp.util.Resource

class RepositoryFragment : Fragment(R.layout.fragment_repository) {
    lateinit var viewModel: RepositoryFragmentViewModel
    lateinit var repositoryAdapter: RepositoriesAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel

        initRecyclerView()


        repositoryAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("repository_item",it)
            }
            findNavController().navigate(
                R.id.action_repositoryFragment_to_selectRepositryFragment,
                bundle
            )
        }


        swiperefresh.setOnRefreshListener {
            viewModel.getRepositories()
        }

        viewModel.newRepositoryList.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading ->{
                    isRefreshing()
                }

                is Resource.Success -> {
                    doneRefreshing()
                    it.data?.let { repositoryList ->
                        repositoryAdapter.differ.submitList(repositoryList.items)

                    }
                }
                is Resource.Error -> {
                    doneRefreshing()
                    Toast.makeText(requireContext(),"An error occured: $it",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun doneRefreshing() {
        swiperefresh.isRefreshing = false
    }

    private fun isRefreshing() {
        swiperefresh.isRefreshing = true
    }

    private fun initRecyclerView() {
        repositoryAdapter = RepositoriesAdapter()
        recyclerViewRepositoryFragment.apply {
            adapter = repositoryAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

}
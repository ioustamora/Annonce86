package eu.saveliev.annonce86.dialogs

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import eu.saveliev.annonce86.R
import eu.saveliev.annonce86.utils.CityHelper

class DialogSpinnerHelper {

    fun ShowSpinnerDialog(context: Context, list: ArrayList<String>) {
        val builder = AlertDialog.Builder(context)
        val rootView = LayoutInflater.from(context).inflate(R.layout.spinner_layout, null)
        val adapter = RcViewDialogSpinner()
        val rcView = rootView.findViewById<RecyclerView>(R.id.rcSpView)
        val sv = rootView.findViewById<SearchView>(R.id.svSpinner )
        rcView.layoutManager = LinearLayoutManager(context)
        rcView.adapter = adapter
        builder.setView(rootView)
        adapter.updateAdapter(list)
        setSearchViewListener(adapter,list, sv)
        builder.show()
    }

    private fun setSearchViewListener(adapter: RcViewDialogSpinner, list: ArrayList<String>, sv: SearchView?) {
        sv?.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val tempList = CityHelper.filterListData(list, newText)
                adapter.updateAdapter(tempList)
                return true
            }

        })
    }
}
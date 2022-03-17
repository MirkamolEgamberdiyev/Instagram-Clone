//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.GridLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//
//import com.wonmirzo.model.MessageItem
//import com.wonmirzo.model.SearchItem
//
//class SearchFragment : Fragment() {
//    private lateinit var recyclerView: RecyclerView
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//
//
//
//    }
////        val view = inflater.inflate(R.layout.fragment_search, container, false)
////        recyclerView = view.findViewById(R.id.recyclerView)
////        recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
////
////        refreshAdapter(getAllMessages())
////        return view
////    }
//
////    private fun refreshAdapter(items: ArrayList<SearchItem>) {
////        recyclerView.adapter = SearchItemAdapter(requireContext(), items)
////    }
////
////    private fun getAllMessages(): ArrayList<SearchItem> {
////        val items: ArrayList<SearchItem> = ArrayList()
////
////        items.add(
////            SearchItem(
////                "https://images.unsplash.com/photo-1568602471122-7832951cc4c5?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8bWFufGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
////                "Mark Zukerberg"
////            )
////        )
////        items.add(
////            SearchItem(
////                "https://images.unsplash.com/photo-1496440737103-cd596325d314?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8Z2lybHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
////                "Valeria Elash"
////            )
////        )
////        items.add(
////            SearchItem(
////                "https://images.unsplash.com/photo-1557862921-37829c790f19?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8bWFufGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
////                "Lim Yon Hi"
////            )
////        )
////        items.add(
////            SearchItem(
////                "https://images.unsplash.com/photo-1514315384763-ba401779410f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Z2lybHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
////                "Sonia Helis"
////            )
////        )
////        items.add(
////            SearchItem(
////                "https://images.unsplash.com/photo-1568602471122-7832951cc4c5?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8bWFufGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
////                "Mark Zukerberg"
////            )
////        )
////
////        return items
////    }
//
//
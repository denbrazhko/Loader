package com.example.loader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loader.models.DataX
import com.example.loader.models.Group
import com.example.loader.network.GetGroupsCallback
import com.example.loader.network.GetGroupsWorker

class MainActivity : AppCompatActivity(), GetGroupsCallback {

    private lateinit var titleTV: TextView
    private lateinit var recycler: RecyclerView
    private lateinit var adapter: RecyclerAdapter
    private lateinit var recyclerLayout: ConstraintLayout
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        showProgress()
        setSpannable()
        getGroups()
    }

    private fun initViews() {
        titleTV = findViewById(R.id.title_activity_tv)
        recycler = findViewById(R.id.rv)
        progressBar = findViewById(R.id.progress)
        recyclerLayout = findViewById(R.id.recycler_cl)
    }

    private fun setSpannable() {
        val s1 = getString(R.string.title_normal)
        val s2 = getString(R.string.title_blue)
        val endOfSpannable = s1.length + s2.length + 1
        val builder = SpannableStringBuilder()
        builder.append(s1)
        builder.append(" ")
        builder.append(s2)
        builder.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this, R.color.spannable_color)),
            s1.length + 1,
            endOfSpannable,
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        titleTV.text = builder
    }

    private fun getGroups() {
        GetGroupsWorker.execute(this)
    }

    private fun initRecycler(data: List<DataX>) {
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter = RecyclerAdapter(this, data)
        recycler.adapter = adapter
    }

    private fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    private fun hideProgress() {
        progressBar.visibility = View.GONE
        recyclerLayout.visibility = View.VISIBLE
    }

    private fun notifyError() {
        TODO("Not yet implemented")
    }

    override fun onError(error: Throwable) {
        hideProgress()
        notifyError()
    }

    override fun onSuccess(data: List<DataX>) {
        hideProgress()
        initRecycler(data)
    }
}
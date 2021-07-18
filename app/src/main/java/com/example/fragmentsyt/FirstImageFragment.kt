package com.example.fragmentsyt

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

private val imageUrl1 = "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/medium-sized-dogs-1613083812.jpg?crop=1.00xw:0.752xh;0,0&resize=768:*"

class FirstImageFragment: Fragment() {

    companion object{
        fun newInstance() = FirstImageFragment()
    }
     lateinit var mProgressBar: ProgressBar

    //private val imageUrl2 = "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/medium-dog-breeds-border-collie-1613075882.jpg?crop=0.9721196690006366xw:1xh;center,top&resize=980:*"
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?,): View? {
        val inflater = inflater.inflate(R.layout.first_image_fragment, container, false)
        mProgressBar  = inflater.findViewById(R.id.firstFragmentProgressBar)
        return inflater
    }

    private fun loadFirstImageUrl(){
        mProgressBar.visibility = View.VISIBLE

        activity?.let {
            Glide.with(it).asBitmap()
                .load(Uri.parse(imageUrl1))
                .into()
        }
    }
}
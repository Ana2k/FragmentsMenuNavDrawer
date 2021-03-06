package com.example.fragmentsyt

import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.bumptech.glide.request.transition.Transition
import com.example.fragmentsyt.databinding.FirstImageFragmentBinding


class FirstImageFragment: Fragment() {

    private val imageUrl1 = "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/medium-sized-dogs-1613083812.jpg?crop=1.00xw:0.752xh;0,0&resize=768:*"

    companion object{
        fun newInstance() = FirstImageFragment()
    }

    private var _binding: FirstImageFragmentBinding? = null
    private val binding
    get() = _binding!!

    //private val imageUrl2 = "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/medium-dog-breeds-border-collie-1613075882.jpg?crop=0.9721196690006366xw:1xh;center,top&resize=980:*"
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?,): View? {
        _binding = FirstImageFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        Log.d("Ana","onCreateView1")
        return view
    }

    private fun loadFirstImageUrl(){
        var mImage = binding.firstFragmentImage
        var mProgressBar = binding.firstFragmentProgressBar
        mProgressBar.visibility = View.VISIBLE
        Log.d("Ana","onLoadfirstImage1")

         Glide.with(requireActivity()).asBitmap()
                .load(Uri.parse(imageUrl1))
                .into(object: BitmapImageViewTarget(mImage){
                    override fun onResourceReady(resource: Bitmap,transition: Transition<in Bitmap>?,) {
                        super.onResourceReady(resource, transition)
                        mProgressBar.visibility = View.INVISIBLE
                        Log.d("Ana","onResourceReady1 inside first image")
                    }
                })
        }

    //onActivityCreated is deprecated so onViewCreated() will be used.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadFirstImageUrl()
        Log.d("Ana","onViewCreated1")
    }
}
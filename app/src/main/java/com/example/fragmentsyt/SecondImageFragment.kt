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
import com.example.fragmentsyt.databinding.SecondImageFragmentBinding


class SecondImageFragment: Fragment() {

    private val imageUrl2 = "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/medium-dog-breeds-border-collie-1613075882.jpg?crop=0.9721196690006366xw:1xh;center,top&resize=980:*"

    companion object{
        fun newInstance() = SecondImageFragment()
    }

    private var _binding: SecondImageFragmentBinding? = null
    private val binding
    get() = _binding!!

    //private val imageUrl2 = "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/medium-dog-breeds-border-collie-1613075882.jpg?crop=0.9721196690006366xw:1xh;center,top&resize=980:*"
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?,): View? {
        _binding = SecondImageFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        Log.d("Ana","onCreateView2")
        return view
    }

    private fun loadSecondImageUrl(){
        var mImage = binding.secondFragmentImage
        var mProgressBar = binding.secondFragmentProgressBar
        mProgressBar.visibility = View.VISIBLE
        Log.d("Ana","onLoadfirstImage2")

        Glide.with(requireActivity()).asBitmap()
            .load(Uri.parse(imageUrl2))
            .into(object: BitmapImageViewTarget(mImage){
                override fun onResourceReady(resource: Bitmap,transition: Transition<in Bitmap>?,) {
                    super.onResourceReady(resource, transition)
                    mProgressBar.visibility = View.INVISIBLE
                    Log.d("Ana","onResourceReady2 inside second image")
                }
            })
    }



    //onActivityCreated is deprecated so onViewCreated() will be used.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadSecondImageUrl()
        Log.d("Ana","onViewCreated2")
    }
}
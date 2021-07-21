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
import com.example.fragmentsyt.databinding.ThirdImageFragmentBinding


class ThirdImageFragment: Fragment() {

    private val imageUrl3 = "https://vetstreet.brightspotcdn.com/dims4/default/83afc7b/2147483647/thumbnail/645x380/quality/90/?url=https%3A%2F%2Fvetstreet-brightspot.s3.amazonaws.com%2Fa3%2F93%2F1d82d4f54148be6a4540ff0e7583%2FGolden-Retriever-AP-D9B8WE-645sm31714.jpg"

    companion object{
        fun newInstance() = ThirdImageFragment()
    }

    private var _binding: ThirdImageFragmentBinding? = null
    private val binding
    get() = _binding!!

    //private val imageUrl2 = "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/medium-dog-breeds-border-collie-1613075882.jpg?crop=0.9721196690006366xw:1xh;center,top&resize=980:*"
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?,): View? {
        _binding = ThirdImageFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        Log.d("Ana","onCreateView1")
        return view
    }

    private fun loadThirdImageUrl(){
        var mImage = binding.thirdFragmentImage
        var mProgressBar = binding.thirdFragmentProgressBar
        mProgressBar.visibility = View.VISIBLE
        Log.d("Ana","onLoadThirdImage1")

         Glide.with(requireActivity()).asBitmap()
                .load(Uri.parse(imageUrl3))
                .into(object: BitmapImageViewTarget(mImage){
                    override fun onResourceReady(resource: Bitmap,transition: Transition<in Bitmap>?,) {
                        super.onResourceReady(resource, transition)
                        mProgressBar.visibility = View.INVISIBLE
                        Log.d("Ana","onResourceReady1 inside Third image")
                    }
                })
        }

    //onActivityCreated is deprecated so onViewCreated() will be used.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadThirdImageUrl()
        Log.d("Ana","onViewCreated1")
    }
}
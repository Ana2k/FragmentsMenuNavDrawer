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

    private var imageUrl3 = "https://animalso.com/wp-content/uploads/2016/11/small-golden-retriever_2.jpg"
    //https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/labrador-retriever-dog-standing-in-field-royalty-free-image-590852449-1565105303.jpg?crop=0.732xw:1.00xh;0.196xw,0&resize=768:*
    //better fittng image
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
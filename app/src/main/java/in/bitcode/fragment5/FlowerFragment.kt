package `in`.bitcode.fragment5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class FlowerFragment : Fragment(), FlowerPickerFragment.OnFlowerClickListener {

    private lateinit var imgFlower : ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.flower_fragment, null)
        imgFlower = view.findViewById(R.id.imgFlower)

        return view
    }

    override fun onFlowerClick(flowerType: Int, flowerImageId: Int) {
        imgFlower.setImageResource(flowerImageId)
    }

    fun setImage(imageId : Int) {
        imgFlower.setImageResource(imageId)
    }
}
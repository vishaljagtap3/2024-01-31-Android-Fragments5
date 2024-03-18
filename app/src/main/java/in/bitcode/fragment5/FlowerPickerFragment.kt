package `in`.bitcode.fragment5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FlowerPickerFragment : Fragment() {

    private lateinit var btnRose: Button
    private lateinit var btnSFlower: Button
    private lateinit var btnTulip: Button

    //way 3
    interface OnFlowerClickListener {
        fun onFlowerClick(flowerType : Int, flowerImageId : Int)
    }
    var onFlowerClickListener : OnFlowerClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.flower_picker_fragment, null)
        initViews(view)
        //initListener1()
        //initListener2()
        initListener3()
        return view
    }

    private fun initListener3() {

        btnRose.setOnClickListener {
            onFlowerClickListener?.onFlowerClick(1, R.drawable.rose)
        }

        btnSFlower.setOnClickListener {
            onFlowerClickListener?.onFlowerClick(2, R.drawable.sunflower)
        }

        btnTulip.setOnClickListener {
            onFlowerClickListener?.onFlowerClick(3, R.drawable.tulip)
        }


    }

    //way 2
    private fun initListener2() {
        val flowerFragment =
            //(requireActivity().supportFragmentManager.findFragmentById(R.id.flowerFragment) as FlowerFragment)
            (parentFragmentManager.findFragmentById(R.id.flowerFragment) as FlowerFragment)

        btnRose.setOnClickListener {
            flowerFragment.setImage(
                R.drawable.rose
            )
        }

        btnSFlower.setOnClickListener {
            flowerFragment.setImage(
                R.drawable.sunflower
            )
        }

        btnTulip.setOnClickListener {
            flowerFragment.setImage(
                R.drawable.tulip
            )
        }


    }

    //way 1
    private fun initListener1() {
        btnRose.setOnClickListener {
            (activity as MainActivity).setImageToFlowerFragment(
                R.drawable.rose
            )
        }

        btnSFlower.setOnClickListener {
            (activity as MainActivity).setImageToFlowerFragment(
                R.drawable.sunflower
            )
        }

        btnTulip.setOnClickListener {
            (activity as MainActivity).setImageToFlowerFragment(
                R.drawable.tulip
            )
        }
    }

    private fun initViews(view: View) {
        btnRose = view.findViewById(R.id.btnRose)
        btnSFlower = view.findViewById(R.id.btnSunflower)
        btnTulip = view.findViewById(R.id.btnTulip)
    }

}
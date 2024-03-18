package `in`.bitcode.fragment5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var flowerFragment: FlowerFragment
    private lateinit var flowerPickerFragment: FlowerPickerFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragments()
        initListeners()
    }

    private fun initListeners() {

        //way 3.2
        flowerPickerFragment.onFlowerClickListener = flowerFragment

        //way 3.1
        /*flowerPickerFragment.onFlowerClickListener = object  : FlowerPickerFragment.OnFlowerClickListener {
            override fun onFlowerClick(flowerType: Int, flowerImageId: Int) {
                flowerFragment.setImage(flowerImageId)
            }
        }*/
    }

    //way 1
    fun setImageToFlowerFragment(imageId: Int) {
        flowerFragment.setImage(imageId)
    }

    private fun initFragments() {
        flowerFragment =
            supportFragmentManager.findFragmentById(R.id.flowerFragment) as FlowerFragment
        flowerPickerFragment =
            supportFragmentManager.findFragmentById(R.id.flowerPickerFragment) as FlowerPickerFragment
    }
}
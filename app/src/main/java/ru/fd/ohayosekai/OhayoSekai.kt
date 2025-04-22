package ru.fd.ohayosekai

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.SpannableString
import android.text.style.ClickableSpan

import android.view.View

class OhayoSekai: Activity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        setContentView(R.layout.welcome)
    }

}
class MySpan: ClickableSpan(){
    override fun onClick(p0: View) {
        TODO("Not yet implemented")
    }
}
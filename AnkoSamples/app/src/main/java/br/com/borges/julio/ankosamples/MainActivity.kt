package br.com.borges.julio.ankosamples

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtHello.text = "Hello"

        btnTeste.setOnClickListener({
            txtHello.text = "Clicou !"
        })
    }


    private fun AsyncTaskAnko () {
        doAsync {
            uiThread {
                //... Pré execução
            }

            Thread.sleep(10000)

            uiThread {
                //... Pós execução
            }
        }
    }
}

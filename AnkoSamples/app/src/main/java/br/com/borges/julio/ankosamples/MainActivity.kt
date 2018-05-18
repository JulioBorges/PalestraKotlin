package br.com.borges.julio.ankosamples

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import br.com.borges.julio.ankosamples.db.MyDatabaseOpenHelper
import org.jetbrains.anko.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity(), AnkoLogger {

    val Context.database: MyDatabaseOpenHelper
        get() = MyDatabaseOpenHelper.getInstance(getApplicationContext())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        verticalLayout {
            val name = editText()
            button("Say Hello") {
                onClick { toast("Hello, ${name.text}!") }
            }
        }

        /*txtHello.text = "Hello"

        btnTeste.setOnClickListener({
            txtHello.text = "Clicou !"
        })*/
    }

    private fun asyncTaskAnko () {

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

    private fun toast(){
        Toast.makeText(this, "Mensagem curta", Toast.LENGTH_SHORT)
        Toast.makeText(this, "Mensagem longa", Toast.LENGTH_LONG)
    }

    private fun toastAnko() {

        toast("Mensagem curta")
        longToast("Mensagem longa")

    }

    private fun alertDialog(){

        val builder = AlertDialog.Builder(this)

        builder.setPositiveButton("Ok") { dialog, id ->
            Toast.makeText(this@MainActivity, "Ok", Toast.LENGTH_SHORT)
            dialog.dismiss()
        }

        builder.setNegativeButton("Cancelar") { dialog, id ->
            Toast.makeText(this@MainActivity, "Ok", Toast.LENGTH_SHORT)
            dialog.dismiss()
        }

        builder.setCancelable(false)
        builder.setTitle("Dialog de alerta")
        builder.setMessage("Clique em OK para confirmar, Cancelar para cancelar.")

        val dialog = builder.create()
        dialog.show()
    }

    private fun alertDialogAnko() {

        alert("Clique em OK para confirmar, Cancelar para cancelar.",
                "Dialog de alerta") {
            isCancelable = false

            positiveButton("Ok") {
                toast("Ok")
            }

            negativeButton("Cancelar") {
                toast("Cancelar")
            }
        }.show()

        alert("Essa é uma mensagem simples !"){
            okButton {  }
        }

        val times = listOf("Cruzeiro", "Atlético", "América", "Guarani")
        selector("Para qual time você torce?", times, { dialogInterface, i ->
            toast("Você torce para o ${times[i]}, mesmo?")
        })

    }

    private fun sqLiteAnko(){

        database.use {
            insert("Cliente",
                    "id" to 1,
                    "Nome" to "Julio",
                    "Doc" to "MG1111.4.411"
            )
        }


    }

    private fun intentsKotlin() {

        val intent = Intent(this, LayoutKotlinNormal::class.java)
        intent.putExtra("id", 5)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(intent)

    }

    private fun intentsAnko() {

        // Inicia uma Activity
        startActivity(intentFor<LayoutKotlinNormal>("id" to 5).singleTop())

        // Faz uma ligação
        makeCall("+553700000000")

        // Envia um SMS
        sendSMS("+553700000000", "Mensagem de texto")

        // Abre o browser
        browse("http://google.com.br")

        // Compartilhar um texto
        share("Texto a ser compartilhado", "Assunto")

        // Envia um e-mail
        email("borges.juliocezar@gmail.com", "Assunto", "Conteúdo do e-mail")

    }

    private fun logs() {

        Log.e("TAG_APP", "Error")
        Log.v("TAG_APP", "Verbose")
        Log.i("TAG_APP", "Information")
        Log.w("TAG_APP", "Warning")
        Log.wtf("TAG_APP", "What a fuck error")

    }

    private fun logsAnko() {

        error("Error")
        verbose("Verbose")
        info("Information")
        info("Warning")
        debug(5)
        wtf("What a fuck error")

    }
}

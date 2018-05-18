package br.com.borges.julio.ankosamples

import android.os.AsyncTask

class AsyncTaskKotlin() : AsyncTask<Void, Void, String>() {
    override fun doInBackground(vararg params: Void?): String? {
        Thread.sleep(10000)
        return null
    }

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
    }
}

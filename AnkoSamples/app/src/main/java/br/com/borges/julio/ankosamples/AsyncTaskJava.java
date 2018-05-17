package br.com.borges.julio.ankosamples;

import android.os.AsyncTask;

public class AsyncTaskJava extends AsyncTask<Void, Void, String> {
    @Override
    protected String doInBackground(Void... voids) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //... Pré execução
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        //... Pós execução
    }
}

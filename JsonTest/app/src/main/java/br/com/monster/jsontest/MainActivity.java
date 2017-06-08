package br.com.monster.jsontest;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    public Context context = this;
    public ArrayList<User> arrayListUsers = new ArrayList<>();
    public ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = ProgressDialog.show(MainActivity.this, "Unibratec", "Baixando imagem...");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lerJson();

                    for (int i = 0; i < arrayListUsers.size(); i++) {

                        User user = new User();
                        user.setId(arrayListUsers.get(i).getId());
                        user.setNome(arrayListUsers.get(i).getNome());
                        user.setEmail(arrayListUsers.get(i).getEmail());
                        final String concat = user.getId() + " " + user.getNome() + " " + user.getEmail();

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressDialog.dismiss();
                                Toast.makeText(context, concat, Toast.LENGTH_LONG).show();
                            }
                        });
                    }

                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();



    }

    public void lerJson() throws ExecutionException, InterruptedException, JSONException {

        //se comunicando com o servidor
        BaseRequester baseRequester = new BaseRequester();
        baseRequester.setUrl("http://www.betojunior.com.br/webservice/PacotePaciente/listapacientes.php");
        baseRequester.setContext(context);

        //Caso precise enviar dados para o servidor, utilize o jsonput
        //JSONObject jsonPut = new JSONObject();
        //jsonPut.put("login", login);
        //jsonPut.put("senha", senha);
        //baseRequester.setJsonString(jsonPut.toString());

        //recuperando o json em formato tetxo
        String jsonString = baseRequester.execute(baseRequester).get();

        //transformando o json texto em JsonObject
        //JSONObject jsonObject = new JSONObject(jsonString);

        //transformando o json texto em JsonOArray
        JSONArray jsonArrayUsers = new JSONArray(jsonString);

        for (int i=0; i < jsonArrayUsers.length(); i++) {

            JSONObject jsonObjectUsuario = jsonArrayUsers.getJSONObject(i);

            User user = new User();
            user.setId(Integer.parseInt(jsonObjectUsuario.get("id").toString()));
            user.setNome(jsonObjectUsuario.get("nome").toString());
            user.setSexo(Integer.parseInt(jsonObjectUsuario.get("sexo").toString()));
            user.setTelefone(jsonObjectUsuario.get("telefone").toString());
            user.setCpf(jsonObjectUsuario.get("cpf").toString());
            user.setSus(jsonObjectUsuario.get("sus").toString());
            user.setSenha(jsonObjectUsuario.get("senha").toString());
            user.setEmail(jsonObjectUsuario.get("email").toString());
            user.setEnderecoId(Integer.parseInt(jsonObjectUsuario.get("endereco_id").toString()));
            arrayListUsers.add(user);
        }

    }
}

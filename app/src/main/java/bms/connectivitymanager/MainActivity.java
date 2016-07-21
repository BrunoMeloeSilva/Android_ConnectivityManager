package bms.connectivitymanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void temConexao(View v){
        //obtem o objeto que gerencia as conexoes do S.O. (Wifi, Bluetooth, Mobile(3g, etc).....)
        ConnectivityManager cM = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        //retorna os detalhes sobre a rede padrão ativa no momento.
        NetworkInfo nI = cM.getActiveNetworkInfo();
        //posso obter diversas informacoes sobre a rede padrão ativa no momento
        // , inclusive apenas saber se está conectada ou nao.
        if(nI != null && nI.isConnected()) {
            ((TextView) findViewById(R.id.txt)).setText(nI.toString());
            Toast.makeText(this, "Conectado !", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Desconectado !", Toast.LENGTH_SHORT).show();
        }
    }
}
/* O NetworkInfo contém diversas informações como exemplificado abaixo:
* NetworkInfo:
* [type: MOBILE[UMTS], state: CONNECTED/CONNECTED, reason: connected, extra: epc.tmobile.com,
*  roaming: false, failover: false, isAvailable: true, isConnectedToProvisioningNetwork: false]
*
*  NetworkInfo:
*  type: WIFI[], state: CONNECTED/CONNECTED, reason: (unspecified), extra: "M-A",
*  roaming: false, failover: false, isAvailable: true, isConnectedToProvisioningNetwork: false
*
*  Em um if por exemplo, posso fazer coisas como (nI.getType() == cM.TYPE_WIFI) para saber se a
*   conexao ativa é via Wifi.... OU fazer coisas como:
      NetworkInfo nI2 = cM.getNetworkInfo(cM.TYPE_BLUETOOTH);
      Log.i("TAG","nI = "+nI2.toString());
*   para obter informacoes de um meio especifico, que não necessariamente é o padrão ativo no momento.
*/

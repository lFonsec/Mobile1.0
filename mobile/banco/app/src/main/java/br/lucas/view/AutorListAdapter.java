package br.lucas.view;

import java.util.List;
import br.lucas.lua.model.Autor;
import br.lucas.view.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
public class AutorListAdapter extends BaseAdapter {
    private Context context;
    private List<Autor> lista;
    public AutorListAdapter(Context context, List<Autor> lista) {
        this.context = context;
        this.lista = lista;
    }
    public int getCount() {
        return lista.size();
    }
    public Object getItem(int position) {
        return lista.get(position);
    }
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        // Recupera o autor da posicao atual
        Autor c = lista.get(position);
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.autor_linha_tabela, null);
        // Atualiza o valor do TextView
        TextView nome = (TextView) view.findViewById(R.id.nome);
        nome.setText(c.getNome());
        TextView endereco = (TextView) view.findViewById(R.id.endereco);
        endereco.setText(c.getEndereco());
        TextView cpf = (TextView) view.findViewById(R.id.cpf);
        cpf.setText(String.valueOf(c.getCpf()));
        return view;
    }
}
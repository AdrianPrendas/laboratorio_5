package Adaptador;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kevca.sistemaderecomendacion.R;
import com.example.kevca.sistemaderecomendacion.domain.Usuario;

import java.util.ArrayList;

/**
 * Created by kevca on 4/19/2018.
 */

public class AdaptadorUsuario extends RecyclerView.Adapter<AdaptadorUsuario.UsuarioViewHolder>{

    ArrayList<Usuario> listaUsuarios;
    Context mContext;

    public AdaptadorUsuario(Context mContext, ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
        this.mContext=mContext;
    }


    @Override
    public UsuarioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemlistusuario, parent, false);

        return new UsuarioViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final UsuarioViewHolder holder, int position) {
        Usuario usuario = listaUsuarios.get(position);
        holder.tv_nombreUsuario.setText(usuario.getNombre());
        holder.tv_id.setText(String.valueOf(usuario.getId()));
        holder.tv_email.setText(String.valueOf(usuario.getEmail()));


        // loading album cover using Glide library
        //Glide.with(mContext).load("@android:drawable/product.png").into(holder.iv_imagen);

        holder.iv_menup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.iv_menup);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    public class UsuarioViewHolder extends RecyclerView.ViewHolder{
    TextView tv_nombreUsuario,tv_id,tv_email;
    ImageView iv_imagen, iv_menup;

    public UsuarioViewHolder(View itemView) {
        super(itemView);
        tv_nombreUsuario= (TextView) itemView.findViewById(R.id.tv_nombreUsuario);
        tv_id= (TextView) itemView.findViewById(R.id.tv_id);
        tv_email= (TextView) itemView.findViewById(R.id.tv_email);
        iv_imagen = (ImageView) itemView.findViewById(R.id.iv_imagen);
        iv_menup = (ImageView) itemView.findViewById(R.id.iv_menup);

    }


}
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view); //es el que da la vista para el menu
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_usuario, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_cart:
                    Toast.makeText(mContext, "Added to cart", Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        }
    }

}

package Adaptador;

import android.content.Context;
import android.net.Uri;
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
import com.example.kevca.sistemaderecomendacion.bl.CarritoBL;
import com.example.kevca.sistemaderecomendacion.bl.ProductoBL;
import com.example.kevca.sistemaderecomendacion.bl.UsuarioBL;
import com.example.kevca.sistemaderecomendacion.domain.Producto;

import com.bumptech.glide.Glide;
import com.example.kevca.sistemaderecomendacion.domain.Usuario;

import java.util.ArrayList;

/**
 * Created by kevca on 4/19/2018.
 */

public class AdaptadorProducto extends RecyclerView.Adapter<AdaptadorProducto.ProductoViewHolder>{

    ArrayList<Producto> listaProductos;
    Context mContext;

    public AdaptadorProducto(Context mContext, ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
        this.mContext=mContext;
    }


    @Override
    public ProductoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemlistproducto, parent, false);

        return new ProductoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ProductoViewHolder holder, int position) {
        final Producto producto = listaProductos.get(position);
        holder.tv_nombreProducto.setText(producto.getNombre());
        holder.tv_precio.setText(String.valueOf(producto.getPrecio()));
        holder.tv_cantidad.setText(String.valueOf(producto.getCantidad()));

        holder.iv_imagen.setImageResource(mContext.getResources().getIdentifier(producto.getImageUrl(),"drawable",mContext.getPackageName()));




        // loading album cover using Glide library
        //Glide.with(mContext).load("@android:drawable/product.png").into(holder.iv_imagen);

        holder.iv_menup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.iv_menup,producto.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public class ProductoViewHolder extends RecyclerView.ViewHolder{
    TextView tv_nombreProducto,tv_precio,tv_cantidad;
    ImageView iv_imagen, iv_menup;

    public ProductoViewHolder(View itemView) {
        super(itemView);
        tv_nombreProducto= (TextView) itemView.findViewById(R.id.tv_nombreProducto);
        tv_precio= (TextView) itemView.findViewById(R.id.tv_precio);
        tv_cantidad= (TextView) itemView.findViewById(R.id.tv_cantidad);
        iv_imagen = (ImageView) itemView.findViewById(R.id.iv_imagen);
        iv_menup = (ImageView) itemView.findViewById(R.id.iv_menup);
    }


}
    private void showPopupMenu(View view, int productId) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view); //es el que da la vista para el menu
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_producto, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener(productId));
        popup.show();
    }
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {
        int productId;
        public MyMenuItemClickListener(int pId) {
            productId = pId;
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_cart:
                    CarritoBL.Companion.getInstance().read(UsuarioBL.Companion.getSession())
                            .addProducto(ProductoBL.Companion.getInstance().read(productId));
                    Toast.makeText(mContext, "Added to cart", Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        }
    }

}

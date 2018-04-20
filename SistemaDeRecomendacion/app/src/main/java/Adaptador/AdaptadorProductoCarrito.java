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
import com.example.kevca.sistemaderecomendacion.bl.CarritoBL;
import com.example.kevca.sistemaderecomendacion.bl.UsuarioBL;
import com.example.kevca.sistemaderecomendacion.domain.Carrito;
import com.example.kevca.sistemaderecomendacion.domain.Producto;
import com.example.kevca.sistemaderecomendacion.domain.Usuario;

import java.util.ArrayList;

/**
 * Created by kevca on 4/19/2018.
 */

public class AdaptadorProductoCarrito extends RecyclerView.Adapter<AdaptadorProductoCarrito.ProductoCarritoViewHolder>{
    Carrito carrito;
    Usuario usuario;
    ArrayList<Producto> listaProductos;
    Context mContext;

    public AdaptadorProductoCarrito(Context mContext, int id) {
        this.usuario = UsuarioBL.Companion.getInstance().read(id);
        this.carrito=CarritoBL.Companion.getInstance().read(id);
        this.listaProductos= null;
        //this.listaProductos=carrito.getHashtableProductos();
        this.mContext=mContext;
    }


    @Override
    public ProductoCarritoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemlistproductocarrito, parent, false);

        return new ProductoCarritoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ProductoCarritoViewHolder holder, int position) {
        Producto producto = listaProductos.get(position);
        holder.tv_nombreProducto.setText(producto.getNombre());
        holder.tv_precio.setText(String.valueOf(producto.getPrecio()));
        holder.tv_cantidad.setText(String.valueOf(producto.getCantidad()));


        // loading album cover using Glide library
        //Glide.with(mContext).load("@android:drawable/product.png").into(holder.iv_imagen);
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public class ProductoCarritoViewHolder extends RecyclerView.ViewHolder{
    TextView tv_nombreProducto,tv_precio,tv_cantidad;
    ImageView iv_imagen;

    public ProductoCarritoViewHolder(View itemView) {
        super(itemView);
        tv_nombreProducto= (TextView) itemView.findViewById(R.id.tv_nombreProducto);
        tv_precio= (TextView) itemView.findViewById(R.id.tv_precio);
        tv_cantidad= (TextView) itemView.findViewById(R.id.tv_cantidad);
        iv_imagen = (ImageView) itemView.findViewById(R.id.iv_imagen);

    }


}

}

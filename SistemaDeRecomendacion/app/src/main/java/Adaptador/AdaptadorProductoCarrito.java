package Adaptador;

import android.content.Context;
import android.content.Intent;
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

import com.example.kevca.sistemaderecomendacion.CarritoActivity;
import com.example.kevca.sistemaderecomendacion.R;
import com.example.kevca.sistemaderecomendacion.bl.CarritoBL;
import com.example.kevca.sistemaderecomendacion.bl.ProductoBL;
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
        this.carrito = CarritoBL.Companion.getInstance().read(id);
        this.listaProductos = carrito.toList();
        this.mContext=mContext;

        CarritoActivity v = (CarritoActivity) mContext;
        TextView tv_precio = (TextView) v.findViewById(R.id.tv_total);
        tv_precio.setText(String.format("$%.2f",carrito.getPrecioTotal()));
    }


    @Override
    public ProductoCarritoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemlistproducto, parent, false);

        return new ProductoCarritoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ProductoCarritoViewHolder holder, int position) {
        final Producto producto = listaProductos.get(position);
        holder.tv_nombreProducto.setText(producto.getNombre());
        holder.tv_precio.setText(String.format("$%.2f",producto.getPrecio()));
        holder.tv_cantidad.setText(String.valueOf(producto.getCantidad()));

        holder.iv_imagen.setImageResource(mContext.getResources().getIdentifier(producto.getImageUrl(),"drawable",mContext.getPackageName()));

        holder.iv_menup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.iv_menup, producto.getId());
            }
        });

        // loading album cover using Glide library
        //Glide.with(mContext).load("@android:drawable/product.png").into(holder.iv_imagen);
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public class ProductoCarritoViewHolder extends RecyclerView.ViewHolder{
    TextView tv_nombreProducto,tv_precio,tv_cantidad;
    ImageView iv_imagen,iv_menup;

    public ProductoCarritoViewHolder(View itemView) {
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
        inflater.inflate(R.menu.menu_producto_carrito, popup.getMenu());
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
                case R.id.action_delete_cart:
                    CarritoBL.Companion.getInstance().read(UsuarioBL.Companion.getSession())
                            .removeProducto(ProductoBL.Companion.getInstance().read(productId));
                    Toast.makeText(mContext, "Deleted from cart", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext,CarritoActivity.class);
                    CarritoActivity c = (CarritoActivity) mContext;
                    c.finish();
                    mContext.startActivity(intent);
                    return true;
            }
            return false;
        }
    }

}

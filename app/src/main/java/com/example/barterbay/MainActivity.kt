package com.example.barterbay

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.barterbay.util.Product
import com.example.barterbay.util.ProductWrapper
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val value = resources.configuration.orientation
        var spanCount = 2
        if (value == Configuration.ORIENTATION_LANDSCAPE) spanCount = 3
        var gridLayoutManager = GridLayoutManager(this, spanCount)
        recyclerView = findViewById<RecyclerView>(R.id.list).apply{
            setHasFixedSize(false)
            layoutManager = gridLayoutManager
            adapter = ProductAdapter(context, ProductWrapper().products)
        }

        //recyclerView?.layoutManager = gridLayoutManager

    }

    class ProductAdapter(ctx: Context, products: Array<Product>?): RecyclerView.Adapter<ProductViewHolder>() {
        private val inflater: LayoutInflater = LayoutInflater.from(ctx)
        var prods = products
        //private var context:Context = ctx
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder{
            return ProductViewHolder(inflater.inflate(R.layout.activity_item,parent,false))
        }
        override fun getItemCount(): Int {
            return prods!!.size
        }

        override fun onBindViewHolder(holder: ProductViewHolder, postion: Int){
            val product = prods!![postion]
            holder.nameTextView.text = product.name
            holder.userText.text = product.user.getUsername()
            holder.productImage.apply {
                setOnClickListener( ImageClick(context, product))
            }
            Picasso.get()
                .load(product.imageUrl).resize(150,150)
                .placeholder(R.drawable.loading)
                .centerCrop()
                .into(holder.productImage)
            //Glide.with(context).load(product.imageUrl).into(holder.productImage)
        }

    }

    class ProductViewHolder(itemView :View): RecyclerView.ViewHolder(itemView) {
        val nameTextView:TextView = itemView.findViewById(R.id.prodName)
        val productImage: ImageView = itemView.findViewById(R.id.prodImage)
        val userText: TextView = itemView.findViewById(R.id.username)
    }

    class ImageClick(context: Context, product:Product): View.OnClickListener {
        private var mContext: Context = context
        private val mProduct: Product = product
        override fun onClick(v: View?) {
            Toast.makeText(mContext, "You want to buy ${mProduct.user.getUsername()}'s ${mProduct.name}", Toast.LENGTH_LONG).show()
        }

    }
}

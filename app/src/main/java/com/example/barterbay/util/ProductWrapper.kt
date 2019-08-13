package com.example.barterbay.util

class ProductWrapper{
    var products: Array<Product>? = null

    init {
        val carUrl = "https://4bbbf1a84bdddda74be6-d15762d1097319f16b63875f9f176f21.ssl.cf1.rackcdn.com/thumbnails/4JGDF6EE4GA629073/73301c47234adb2dab6b1407a29120c9.jpg"
        val bagUrl = "https://images-na.ssl-images-amazon.com/images/G/01/Shopbop/p//prod/products/manua/manua302181205c/manua302181205c_q1_2-0._UX220_.jpg"
        val ironUrl = "https://www-konga-com-res.cloudinary.com/w_auto,f_auto,fl_lossy,dpr_auto,q_auto/media/catalog/product/V/e/Vertical-Steam-Pressing-Iron-8058310.jpg"
        val laptopUrl= "https://assets.pcmag.com/media/images/507437-dell-latitude-7390.jpg?width=333&height=245"
        val houseUrl = "https://assets.architecturaldesigns.com/plan_assets/324992268/large/23703JD_01_1553616680.jpg?1553616681"
        val sandalUrl = "https://cdn.shopify.com/s/files/1/2170/8465/products/AABFDrTdZIgivOG887u9mnrtxu7krfQi4PLXEyRXWqi6aUCYO3MueJIgJ4rVdeMdE9k8IWaWdkmM7gb46mAWo2-pTAU4jH17QmXqD20UhXqqsTlJSITpAeHpGmg9wpVoedaX5znK7XMIkUXeqQUHsMQIAmbrHUDWhQW1jOwSj5eeuCLE2s6WtrKrLWvBwIM0xlxsJcKG_large.jpg"
        var car = Product("Car", carUrl, User("dave"),"2019-08-09", false)
        var laptop = Product("Dell Latitude", laptopUrl, User("etinosa"),"2019-08-09", false)
        var house = Product("House", houseUrl, User("martin"),"2019-08-09", false)
        var iron = Product("Iron", ironUrl, User("james"),"2019-08-09", false)
        var bag = Product("Bag", bagUrl, User("chuksy"),"2019-08-09", false)
        var sandal = Product("Sandal", sandalUrl, User("ure"),"2019-08-09", false)
        products = arrayOf(car, laptop, house, iron,bag, sandal)
    }

    companion object{
        val instance  = ProductWrapper()
    }
}
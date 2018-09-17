'use strict';

const Router = require('express');
var request = require("request");

const getRecommendationRoutes = (app) => {
    const router = new Router();

    router.post('/', (req, res) => {
        console.log("Esta es el request", req.body);
        var currentCart = req.body;
        if(!currentCart || Object.keys(currentCart).length===0){
            res.status(404).send({
                status: 404,
                message: "Para retornar una recomendación es necesario los items de carrito"
            })
        }else{
            request.get("http://10.51.145.151:9091/api/v1/products", (error, response, body) => {
            if (response.statusCode == 200) {
                //filtar productos
                var products = JSON.parse(response.body);
                if(products.length>0){
                    products = products.filter(prodcat => !currentCart.includes(prodcat.productId));
                }
                console.log(products.length);
                res.send(products);
            } else {
                res.send(response);
            }
        });
        }       
    })

    app.use('/api/v1/recommendations', router);
};

module.exports = getRecommendationRoutes;




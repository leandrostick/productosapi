package com.mercadolibre.itacademy

import grails.rest.Resource

@Resource(uri='/articulos')
class Articulo{


    String name
    String picture


    static belongsTo = [marca:Marca]

    static constraints = {
        name blank: false, nullable: false
    }
}

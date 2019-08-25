package com.mercadolibre.itacademy

import grails.converters.JSON

import java.text.SimpleDateFormat

class BootStrap {

    def init = { servletContext ->
        def todasLasMarcas = new Marca(name:'Todas').save(flush:true)
        def marca1 = new Marca(name:'Adidas').save(flush:true)
        def marca2 = new Marca(name:'Nike').save(flush:true)
        def marca3 = new Marca(name:'Puma').save(flush:true)
        def marca4 = new Marca(name:'Kappa').save(flush:true)
        def marca5 = new Marca(name:'DC').save(flush:true)
        def marca6 = new Marca(name:'Vans').save(flush:true)

        def articulo1 = new Articulo(name:'Zapatillas', picture: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtHCNJePkHaCBX_0Rnl84pUdsCWLhyH9hRFdI8w9uZ-o_-1D7G')
        def articulo2 = new Articulo(name:'Remera', picture: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtHCNJePkHaCBX_0Rnl84pUdsCWLhyH9hRFdI8w9uZ-o_-1D7G')
        def articulo3 = new Articulo(name:'Campera', picture: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtHCNJePkHaCBX_0Rnl84pUdsCWLhyH9hRFdI8w9uZ-o_-1D7G')
        def articulo4 = new Articulo(name:'Gorra', picture: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtHCNJePkHaCBX_0Rnl84pUdsCWLhyH9hRFdI8w9uZ-o_-1D7G')
        def articulo5 = new Articulo(name:'Medias', picture: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtHCNJePkHaCBX_0Rnl84pUdsCWLhyH9hRFdI8w9uZ-o_-1D7G')
        def articulo6 = new Articulo(name:'Musculosa', picture: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtHCNJePkHaCBX_0Rnl84pUdsCWLhyH9hRFdI8w9uZ-o_-1D7G')
        def articulo7 = new Articulo(name:'Pelota de futbol', picture: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtHCNJePkHaCBX_0Rnl84pUdsCWLhyH9hRFdI8w9uZ-o_-1D7G')
        def articulo8 = new Articulo(name:'Pantalon', picture: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtHCNJePkHaCBX_0Rnl84pUdsCWLhyH9hRFdI8w9uZ-o_-1D7G')

        todasLasMarcas.addToArticulos(articulo1).save()
        todasLasMarcas.addToArticulos(articulo2).save()
        todasLasMarcas.addToArticulos(articulo3).save()
        todasLasMarcas.addToArticulos(articulo4).save()
        todasLasMarcas.addToArticulos(articulo5).save()
        todasLasMarcas.addToArticulos(articulo6).save()
        todasLasMarcas.addToArticulos(articulo7).save()
        todasLasMarcas.addToArticulos(articulo8).save()


        marca1.addToArticulos(articulo1).save()
        marca1.addToArticulos(articulo2).save()
        marca2.addToArticulos(articulo3).save()
        marca2.addToArticulos(articulo4).save()
        marca3.addToArticulos(articulo5).save()
        marca4.addToArticulos(articulo6).save()
        marca5.addToArticulos(articulo7).save()
        marca6.addToArticulos(articulo8).save()

        marshaler()

    }

    def destroy = {
    }

    private void marshaler(){   // recibimos un obj hotel y lo mostraoms como objeto json
        JSON.registerObjectMarshaller(Marca){
            marca -> [
                    id:marca.id,
                    name:marca.name,
                    articulos:marca.articulos.collect {  // esto lo podemos hacer por el hasMany
                    articulo -> [
                                id:articulo.id,
                                name:articulo.name,
                                picture:articulo.picture
                        ]
                    }
            ]
        }
        JSON.registerObjectMarshaller(Articulo){
            articulo -> [
                    id:articulo.id,
                    name:articulo.name,
                    picture:articulo.picture,
                    marca:articulo.marca.name

            ]
        }
    }

}

package com.example.projetmobile4a.data.ApiRest.Retrofit

import com.example.projetmobile4a.data.ApiRest.Model.Pokedex
import io.reactivex.Observable
import retrofit2.http.GET

interface IPokemonList {
    @get:GET("pokedex.json")
    val listPokemon:Observable<Pokedex>
}
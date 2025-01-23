package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    /*Injetando uma dependência para implementar o DTO para compor o sistema no componente GameService*/
    @Autowired
    private GameRepository gameRepository;
    public List<GameMinDTO> findAll(){
        /*forma simples: var result = ... */
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x  -> new GameMinDTO(x)).toList();


        /*didaticamente atribui-se uma lista à variável para receber os parâmetros.*/


    }

}

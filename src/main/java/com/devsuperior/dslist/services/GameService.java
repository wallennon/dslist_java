package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    /*Injetando uma dependência para implementar o DTO para compor o sistema no componente GameService*/
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true) /*para garantir que não irei escrever no bd*/
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        /*Implementar um try except para verificar se o id existe*/
        return new GameDTO(result);

    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        /*forma simples: var result = ... */
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x  -> new GameMinDTO(x)).toList();


        /*didaticamente atribui-se uma lista à variável para receber os parâmetros.*/


    }

}

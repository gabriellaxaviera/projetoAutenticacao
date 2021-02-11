package com.piloto.autenticacao.services;

import com.piloto.autenticacao.dto.UserDto;
import com.piloto.autenticacao.model.User;
import com.piloto.autenticacao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UserRepository repository;

    public void validateCpf(UserDto usuarioDto)
    {
        String cpf = usuarioDto.getCpf();
        System.out.println(cpf);
        System.out.println(cpf.length());
        if ((cpf==null) || (cpf.length()!=11))
        {
            System.out.println("CPF INVALIDO");
        }
        else
        {
            login(usuarioDto);
        }
    }


    public void login(UserDto userDto)
    {

        User usuario = repository.findByCpf(userDto.getCpf());
        if (usuario == null)
        {
            System.out.println("USUARIO NAO ENCONTRADO");
        }
        else
        {
            if (usuario.getSenha().equals(userDto.getSenha()))
            {
                System.out.println("OK LOGADO");
            }
            else{
                System.out.println("SENHA INVALIDA");
            }

        }

    }

    // 1- validar cpf: se existe e se realmente é cpf(mascara)
    //se o cpf existir, verificar senha.
    // se cpf nao existir: return usuario nao cadastrado
    // se senha estiver errada: return senha incorreta
    // se cpf e senha estiverem corretos: return OK LOGADO


    //metodos
    // mascara cpf
    // find cpf
    // compareSenha


    //mascara
//    public User validateCpf(UserDto usuarioDto) throws ParseException {
//
//        usuarioDto.getCpf() = cpf.trim().replace(".", "").replace("-", "");
//
//        if ( (cpf==null)||(cpf.length()!=11) )
//        {
//            System.out.println("CPF INVALIDO");
//        }
//        else if (repository.findByCpf(cpf))
//        //if  passar na mascara
//        // repo.findcpf
//        //if repo achar
//        //cpf ok
//        //verificarSenha();
//    }

//    private void verificarSenha(){
//        return "ok";
//    }


}

package com.piloto.autenticacao.services;

import com.piloto.autenticacao.dto.UserDto;
import com.piloto.autenticacao.model.User;
import com.piloto.autenticacao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;

@Service
public class LoginService {

    @Autowired
    UserRepository repository;

    /*public void validateCpf(UserDto usuarioDto)
    {
        String cpf = usuarioDto.getCpf();

       *//* // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999") || (cpf.length() != 11))
        {
            System.out.println("CPF INVALIDO");
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else
                dig11 = (char) (r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
            {
                login(usuarioDto);
            }
            else
            {
                System.out.println("CPF INVALIDO");
            }
        }
        catch (InputMismatchException erro)
        {
             System.out.println(erro);
        }*//*

        if ((cpf==null) || (cpf.length()!=11))
        {
            System.out.println("CPF INVALIDO");
        }
        else
        {
            login(usuarioDto);
        }
    }*/


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

package ru.dasha.doing.OmnicommTask

import org.hamcrest.MatcherAssert
import ru.dasha.AuthorizationApi
import ru.dasha.api.v1.model.LoginParameters
import spock.lang.Specification
import spock.lang.Subject

import javax.ws.rs.client.ClientResponseContext

import static org.hamcrest.Matchers.equalTo
import static org.hamcrest.Matchers.notNullValue

class AuthLoginSpecification extends Specification {

    @Subject
    AuthorizationApi authorizationApi = new AuthorizationApi()
    @Subject
    LoginParameters loginParameters = new LoginParameters()

    // @positive check status code
    def "authLogin check status code"() {
        when:
        loginParameters.login("rudemoru")
        loginParameters.password("rudemo123456")
        def response = authorizationApi.authLoginPostWithHttpInfo(loginParameters, 1)

        then:
        MatcherAssert.assertThat(response.statusCode, equalTo(200))
    }

    // @positive check that response body is not null
    def "authLogin check response body and contains not null"() {
        when:
        loginParameters.login("rudemoru")
        loginParameters.password("rudemo123456")
        def response = authorizationApi.authLoginPostWithHttpInfo(loginParameters, 1)

        then:
        verifyAll {
            MatcherAssert.assertThat(response.data.jwt, notNullValue())
            MatcherAssert.assertThat(response.data.refresh, notNullValue())
        }

    }

    // requires rewriting ApiClient and some wrappers
    // @negative check status code
//    def "authLogin check status code for incorrect data"() {
//        when:
//        loginParameters.login(login)
//        loginParameters.password(password)
//        def response = authorizationApi.authLoginPostWithHttpInfo(loginParameters, 1)
//
//        then:
//        MatcherAssert.assertThat(response.statusCode, equalTo(404))
//
//        where:
//        login      | password
//        "qqq"      | "www"
//        "rudemoru" | "qqq"
//    }

    // verifyAll {}, with {} - assertAll both/sequentially

    // thrown Exception - for asserting exceptions

    // where:
    // a | b | c
    // a | b | c

}
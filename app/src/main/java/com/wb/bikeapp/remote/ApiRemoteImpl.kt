package com.wb.bikeapp.remote

import com.wb.bikeapp.Constants
import com.wb.bikeapp.remote.exceptions.BadRequestException
import com.wb.bikeapp.remote.exceptions.ForbiddenException
import com.wb.bikeapp.remote.exceptions.NotFoundException
import com.wb.bikeapp.remote.exceptions.ServerErrorException
import io.reactivex.Emitter
import io.reactivex.SingleEmitter

abstract class ApiRemoteImpl {


    fun handleStatusCodeToSendEmitter(emitter: SingleEmitter<*>, statusCode: Int) {
        when (statusCode) {
            Constants.HTTPStatus.NOT_FOUND.code -> onNotFoundRequest(emitter)
            Constants.HTTPStatus.BAD_REQUEST.code -> onBadRequest(emitter)
            Constants.HTTPStatus.FORBIDDEN.code -> onForbiddenRequest(emitter)
            Constants.HTTPStatus.INTERNAL_SERVER_ERROR.code -> onServerError(emitter)
        }
    }

    private fun onNotFoundRequest(emitter: SingleEmitter<*>) {
        emitter.onError(NotFoundException())
    }

    private fun onBadRequest(emitter: SingleEmitter<*>) {
        emitter.onError(BadRequestException())
    }

    private fun onForbiddenRequest(emitter: SingleEmitter<*>) {
        emitter.onError(ForbiddenException())
    }

    private fun onServerError(emitter: SingleEmitter<*>) {
        emitter.onError(ServerErrorException())
    }

}






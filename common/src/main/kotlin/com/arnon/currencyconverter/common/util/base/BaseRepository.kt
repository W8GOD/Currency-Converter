package com.arnon.currencyconverter.common.util.base

abstract class BaseRepository<T> {

    private var cacheIsDirty = false

    abstract suspend fun getResultFromRemoteDataSource(): T

    abstract suspend fun getResultFromLocalDataSource(): T?
}
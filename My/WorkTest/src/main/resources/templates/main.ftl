<#import "parts/common.ftl" as c>

<@c.page>
    <div class="form-row">
    <div class="form-group col-md-6">
    <form method="get" action="/main" class="form-inline">
        <input type="text" name="filter" class="form-control" placeholder="Write VIN" value="${filter?ifExists}" >
        <button type="submit" class="btn btn-primary ml-2">Search </button>
    </form>
    </div>
    </div>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Add new Car
    </a>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" name="modelAuto" class="form-control" placeholder="Введите марку авто"/>
                </div>
                <div class="form-group">
                    <input type="text" name="mileage" class="form-control" placeholder="Пробег, км"/>
                </div>
                <div class="form-group">
                    <input type="text" name="text" class="form-control" placeholder="Вид работ"/>
                </div>
                <div class="form-group">
                    <input type="text" name="tag" class="form-control" placeholder="VIN">
                </div>
                <div class="form-group">
                    <div class="custom-file">
                        <input type="file" name="file" id="customFile">
                        <label class="custom-file-label" for="customFile">Choose file</label>
                    </div>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary ">Добавить запись!</button>
                </div>
            </form>
        </div>
    </div>

    <div class="card-columns">
        <#list messages as message>
            <div class="card my-3">
                <ul class="list-group list-group-flush">
                <#if message.filename??>
                    <li class="list-group-item">
                        <img src="/img/${message.filename}" class="card-img-top"> </li>
                </#if>
                <div class="m-2">

                        <li class="list-group-item">
                            <h6 class="card-title">Model:</h6>
                            ${message.modelAuto}
                        </li>

                        <li class="list-group-item">
                            <h6 class="card-title">Mileage:</h6>
                            ${message.mileage}  </li>

                        <li class="list-group-item">
                            <h6 class="card-title">  Description:</h6>
                            ${message.text}  </li>

                        <li class="list-group-item">
                            <h6 class="card-title"> Vin code: </h6>
                            <i>${message.tag}</i>  </li>


                </div>
                </ul>
                <div class="card-footer text-muted">
                    <h6 class="card-title"> Author: </h6>
                    ${message.authorName}
                </div>

            </div>
        <#else>
            No auto
        </#list>
    </div>
</@c.page>
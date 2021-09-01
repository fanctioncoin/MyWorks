<#include "security.ftl">
<#import "login.ftl" as l>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Repair History</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav  me-auto">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/main">Base Auto</a>
                </li>
                <#if isAdmin>

                    <li class="nav-item">
                        <a class="nav-link active"  href="/user">User list</a>
                    </li>
                </#if>
                <#if user??>

                    <li class="nav-item">
                        <a class="nav-link active"  href="/user/profile">Profile</a>
                    </li>
                </#if>
            </ul>

            <div class="navbar-text me-5 ">${name}</div>
           <@l.logout />
        </div>
    </div>
</nav>
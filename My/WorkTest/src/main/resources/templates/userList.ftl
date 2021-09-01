<#import "parts/common.ftl" as c>
<@c.page>


    <p class="h3 text-center">LIST OF USERS</p>
  <table class="table  table-striped table-sm">
 <thead class="table-dark">
 <tr>
 <th scope="col"> Name</th>
 <th scope="col"> Role</th>
 <th scope="col">Alteration</th>
 </tr>
 </thead>
<tbody>


  <#list users as user>
<tr>
      <td>${user.username}</td>
      <td><#list user.roles as role>${role}<#sep>, </#list> </td>
      <td><a href="/user/${user.id}"> edit</a> </td>
</tr>
  </#list>
</tbody>
  </table>
</@c.page>
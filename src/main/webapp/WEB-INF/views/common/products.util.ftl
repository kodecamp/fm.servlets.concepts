<#-- This is user defined macro with isVertical defaults to 'false' and color defaults to 'lightgray' -->
<#-- styles can accepts many number of args -->
<#macro productDetails p isVertical=false styles...>
  <#assign finalStyle="">
    <#list styles as prop,propValue>
      <#assign finalStyle = (finalStyle+prop+":"+propValue +";")>
    </#list>
  <div class='inline-box ${isVertical?then("vertical","horizontal")}' style="${finalStyle}">
    <p style="font-weight: bold;">${p.name}</p>
    <p>${p.url}</p>
    <p>${p.price}</p>
  </div>
</#macro>
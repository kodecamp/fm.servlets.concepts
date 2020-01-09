<#include "./common/header.ftl">
<#import "./common/products.util.ftl" as productUtils> 

<div class="container center">
  <div>
    <#list pageValues.products as product>
    <#-- using user defined macro -->
        <@productUtils.productDetails p=product isVertical=true
        background\-color=(product?index%2 == 0)?then('darkgray','tomato') border = "1px solid #323232"/> 
    </#list>
  </div>
</div>
<div style="text-align:center;">
    <#list 1..<11 as no>
      <span class="page-no">${no}</span>
    </#list>
</div>
</br>
</br>
</br>
<div style="text-align:center;">
   <#assign x = 0>
   <#list 100..110 as pos> 
     <#if pos%2 == 0>
       <span class="circle">${x}</span> → <span class="page-no" style="background:seagreen;color: white;">${pos}</span>
       <#else>
         <span class="circle">${x}</span> → <span class="page-no" style="background: purple; color: white;">${pos}</span>
     </#if>
     <#assign x+=1>
   </#list>
</div>
<#include "/common/footer.ftl">
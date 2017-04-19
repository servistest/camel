<#--${msg}-->
<#--${msg?xml}-->

${body}
${body.failure}

<#if body.failure?? && (body.failure.errors??) >
<p> Body.failure: ${body.failure}</p>
</#if>

<#--${body.failure.errors}-->





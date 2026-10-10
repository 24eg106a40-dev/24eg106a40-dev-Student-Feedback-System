Write-Host "Checking port 8080..."

$connections = Get-NetTCPConnection -LocalPort 8080 -State Listen -ErrorAction SilentlyContinue

if ($connections) {
    $pids = $connections | Select-Object -ExpandProperty OwningProcess -Unique

    foreach ($processId in $pids) {
        Write-Host "Stopping process $processId on port 8080..."
        Stop-Process -Id $processId -Force -ErrorAction SilentlyContinue
    }

    Start-Sleep -Seconds 2
}

Write-Host "Starting Student Feedback System..."
.\mvnw.cmd spring-boot:run
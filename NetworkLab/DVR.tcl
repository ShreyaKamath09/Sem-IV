set ns [new Simulator]

$ns rtproto DV

set nf [open dvr.nam w]
$ns namtrace-all $nf

set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]

proc finish {} {
global ns nf
$ns flush-trace
close $nf
exec nam dvr.nam &
exit 0
}

$ns duplex-link $n0 $n1 10Mb 10ms DropTail
$ns duplex-link $n0 $n3 10Mb 10ms DropTail
$ns duplex-link $n1 $n2 10Mb 10ms DropTail
$ns duplex-link $n3 $n2 10Mb 10ms DropTail
$ns duplex-link $n0 $n2 20Mb 10ms DropTail
$ns duplex-link $n1 $n3 20Mb 10ms DropTail

$ns duplex-link-op $n0 $n1 orient right
$ns duplex-link-op $n0 $n3 orient down
$ns duplex-link-op $n1 $n2 orient down
$ns duplex-link-op $n3 $n2 orient right
$ns duplex-link-op $n0 $n2 orient right-down
$ns duplex-link-op $n1 $n3 orient left-down

set tcp [new Agent/TCP]
$ns attach-agent $n0 $tcp
$tcp set Class_ 2

set sink [new Agent/TCPSink]
$ns attach-agent $n2 $sink

$ns connect $tcp $sink

set ftp [new Application/FTP]
$ftp attach-agent $tcp
$ftp set type_ FTP
$ftp set packet_size_ 1000
$ftp set rate_ 1Mb

$ns at 0.1 "$ftp start"
$ns rtmodel-at 0.3 down $n0 $n2
$ns rtmodel-at 0.9 up $n0 $n2
$ns at 1.2 "$ftp stop"
$ns at 1.5 "finish"

$ns run

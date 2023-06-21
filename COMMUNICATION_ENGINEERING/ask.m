clc
close all
clear all
fc=input('Freq of Sine Wave carrier:');
fp=input('Freq of Periodic Binary pulse (Message):');
amp=input('Enter the amplitude (For Both):');
t=0:0.001:1; %sampling interval
c=amp.*sin(2*pi*fc*t);%Carrier Sine wave
subplot(4,1,1) %Carrier wave
plot(t,c)
xlabel('Time')
ylabel('Amplitude')
title('Carrier Wave')
m=amp/2.*square(2*pi*fp*t)+(amp/2);
subplot(4,1,2) %Square Binary Pulse (Message)
plot(t,m)
xlabel('Time')
ylabel('Amplitude')
title('Binary Message Pulses')
w=c.*m;
subplot(4,1,3) %Amplitude Shift Keyed Wave Modulation
plot(t,w)
xlabel('Time')
ylabel('Amplitude')
title('Amplitide Shift Keyed Signal modulated');
x=square(demod(w,fc,fc*fc,'fm')); 
subplot(4,1,4) %Amplitude Shift Keyed Wave Demodulation
plot(t,x)
xlabel('Time')
ylabel('Amplitude')
title('ASK Demodulated')


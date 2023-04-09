output "ec2_id" {
  value = aws_instance.server.id
}
output "ec2_ami" {
  value = aws_instance.server.ami
}
output "ec2_instanceType" {
  value = aws_instance.server.instance_type
}
output "ec2_AZ" {
  value = aws_instance.server.availability_zone
}
output "public_ip" {
  value = aws_instance.server.public_ip
}
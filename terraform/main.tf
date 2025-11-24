terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.0"
    }
  }
}

provider "aws" {
  region = "us-east-1"
}

# ON UTILISE LE RÔLE PRÉ-CRÉÉ PAR LE LAB (voclabs)
data "aws_iam_role" "eks_cluster_role" {
  name = "voclabs"  # Ce rôle existe déjà dans tous les labs voclabs
}

# Cluster EKS avec le rôle existant
resource "aws_eks_cluster" "cluster" {
  name     = "mykubernetes-g3"
  role_arn = data.aws_iam_role.eks_cluster_role.arn
  version  = "1.30"

  vpc_config {
    subnet_ids              = var.private_subnet_ids
    endpoint_public_access  = true
    public_access_cidrs     = ["0.0.0.0/0"]
  }
}

# Node group avec le rôle existant aussi
resource "aws_eks_node_group" "nodes" {
  cluster_name    = aws_eks_cluster.cluster.name
  node_group_name = "workers"
  node_role_arn   = data.aws_iam_role.eks_cluster_role.arn  # même rôle
  subnet_ids      = var.private_subnet_ids

  scaling_config {
    desired_size = 2
    max_size     = 3
    min_size     = 1
  }

  capacity_type  = "SPOT"
  instance_types = ["t3.medium"]

  # Très important dans les labs : pas de taints
  taint {
    key    = "spot"
    value  = "true"
    effect = "NO_SCHEDULE"
  }
}

output "cluster_name" {
  value = aws_eks_cluster.cluster.name
}

output "endpoint" {
  value = aws_eks_cluster.cluster.endpoint
}